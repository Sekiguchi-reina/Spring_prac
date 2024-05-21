package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/index")
	public List<Article> getNews(){
		return newsService.fetchNews();
		}
	
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

}
