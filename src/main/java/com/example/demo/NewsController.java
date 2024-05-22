package com.example.demo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@GetMapping("/index")
	public String getNews(Model model) {
	    CompletableFuture<List<Article>> futureArticles = newsService.fetchNews();

	    try {
	        List<Article> articles = futureArticles.get(); // 非同期処理の完了を待機
	        if (articles != null) {
	            model.addAttribute("articles", articles);
	            return "index";
	        } else {
	            return "error";
	        }
	    } catch (InterruptedException | ExecutionException e) {
	        e.printStackTrace();
	        return "error";
	    }
	}
}

//	@GetMapping("/index")
//	public List<Article> getNews() throws InterruptedException, ExecutionException {
//		return newsService.fetchNews().get();
//	}

//	@GetMapping("index")
//	public String getNews(Model model) {
//		List<Article> articles = null;
//		try {
//			articles = newsService.fetchNews().get();
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
//		model.addAttribute("articles",articles);
//		return "index";
//	}
//}
//	public List<Article> getNews(){
//		return newsService.fetchNews();
//		}

//	@GetMapping("/index")
//	public String showNewsList(Model model) {
//		model.addAttribute("newsList",newsService.getNewsList());
//		
//		return "newsList";
//	}
//	
//	@PostMapping("/news/detail")
//	public News getNewDetail(@RequestBody Integer id) {
//		return newsService.getNewsDetail(id);
//	}
//	
//	@PostMapping("/fetch-news")
//	public ResponseEntity<String> fetchAndSaveNewsData(){
//		try {
//			newsService.fetchAndSaveNewsData();
//			return ResponseEntity.ok("News data fetched and saved successfully!");
//		} catch(Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch and save news data:" + e.getMessage());
//		}
//	}
//	@GetMapping("/news/{id}")
//    public News getNewDetail(@PathVariable Integer id) {
//        return newsService.getNewsDetail(id);
//    }
