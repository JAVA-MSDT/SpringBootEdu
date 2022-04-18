package com.msdt.springmvc.controller;

import com.msdt.springmvc.entity.Product;
import com.msdt.springmvc.service.ProductService;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    private final ProductService productService;
    private final AsyncTaskExecutor asyncTaskExecutor;

    public SearchController(ProductService productService, AsyncTaskExecutor asyncTaskExecutor) {
        this.productService = productService;
        this.asyncTaskExecutor = asyncTaskExecutor;
    }

    @GetMapping("/search")
    public DeferredResult<ModelAndView> search(@RequestParam("search") String search, ModelAndView modelAndView, HttpServletRequest request) {
       DeferredResult<ModelAndView> deferredResult = new DeferredResult<>();

        modelAndView.setViewName("search:: " + search);
        modelAndView.setViewName("search");
        System.out.println("Async Flag: " + request.isAsyncSupported());
        System.out.println("Thread Name from Servlet container: " + Thread.currentThread().getName());

        asyncTaskExecutor.execute(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread Name from DeferredResult: " + Thread.currentThread().getName());
            List<Product> products = productService.searchByName(search);
            modelAndView.addObject("products", products);
             deferredResult.setResult(modelAndView);
        });
        return deferredResult;
    }
}
