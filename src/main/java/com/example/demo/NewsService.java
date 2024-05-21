package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

@Service
public class NewsService {

	//	//データベース操作が必要ならリポジトリが要る
	//	@Autowired
	//	private NewsRepository newsRepository;

	@Value("${news.api.key}")
	private String apikey;

	//NewsAPIからデータ取得
	//	private static final String NEWS_API_URL = "http://newsapi.org/v2/top-headlines?country=jp&apikey=06d4ac883c8e400496cc9ebd9cd78085";

	public List<Article> fetchNews() {
		NewsApiClient newsApiClient = new NewsApiClient(apikey);
		List<Article> articles = new ArrayList<>();
		
		CompletableFuture<Void> future = new CompletableFuture<>();

			newsApiClient.getTopHeadlines(
					new TopHeadlinesRequest.Builder()
							.language("en")
							.build(),

					new NewsApiClient.ArticlesResponseCallback() {

						@Override
						public void onSuccess(ArticleResponse response) {
							if(response != null && response.getArticles() != null) {
								articles.addAll(response.getArticles());
							}
								future.complete(null);
						}

						@Override
						public void onFailure(Throwable throwable) {
							System.out.println("Failed to fetch news:" + throwable.getMessage());
							future.completeExceptionally(throwable);
						}
					});
			
		future.join();

		return articles;
	}
}
//ニュース記事のリストを格納する変数
//		private List<News> newsList;
//		
//		//ニュース記事のリストを取得
//		public List<News> getNewsList(){
//			//ニュース記事のリストを返す
//			return newsList;
//		}

//	//指定されたIDのニュースの詳細情報を取得
//	public News getNewsDetail(int id) {
//		for(News news : newsList) {
//			if(news.getId() == id) {
//				return news;
//			}
//		}
//		
//		//IDに対応するニュースが見つからないとき
//		return null;
//	}
//	
//	//ニュース情報をAPIから取得してデータベースに保存
//	public void fetchAndSaveNewsData() {
//		try {
//			RestTemplate restTemplate = new RestTemplate();
//			ResponseEntity<String> response = restTemplate.getForEntity(NEWS_API_URL, String.class);
//			if(response.getStatusCode() == HttpStatus.OK) {
//				String responseBody = response.getBody();
//				
//				//JSONとかXML形式のAPIのレスポンスを適切にパースして、オブジェクトに変換
//				News news = parseNewsData(responseBody);
//				newsRepository.save(news);
//			} else {
//				System.out.println("保存に失敗しました");
//			}
//		} catch (Exception e) {
//			System.out.println("例外が発生しました");
//		}
//		
//	}
//	
//	private News parseNewsData(String responseBody) {
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			News news = 
//		}
//	}
