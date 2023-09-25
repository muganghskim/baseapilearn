package com.example.demo.controller;

import com.example.demo.data.HSData;
import com.example.demo.repository.HSRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class HSDataController {
    private static final Logger logger
            = LoggerFactory.getLogger(HSDataController.class);

    private final HSRepository hsRepository;

    public HSDataController(HSRepository hsRepository) {
        this.hsRepository = hsRepository;
    }
//    html form 요청시
//    @GetMapping("/")
//    public String findAll() {
//        logger.info("로그 왜 안찍혀");
//
//        return "index.html";
//    }
//
//    @PostMapping("/insert")
//    @ResponseBody
//    public HSData create(@ModelAttribute HSData hsdata) {
//        logger.info("포스트 = {}, {}", hsdata.getName(), hsdata.getPrice());
//
//        return hsRepository.save(hsdata);
//    }
//
//
//
//    @PutMapping("/update/{id}")
//    @ResponseBody
//    public HSData updata(@PathVariable Long id, @ModelAttribute HSData hsdata) {
//        hsdata.setId(id);
//
//        return hsRepository.save(hsdata);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable Long id) {
//        hsRepository.deleteById(id);
//    }

//    API 사용시
      @GetMapping("/")
        public List<HSData> findAll() {

        return hsRepository.findAll();
      }
      @GetMapping("/{id}")
      public Optional<HSData> find(@PathVariable Long id) {

        return hsRepository.findById(id);
      }


      @PostMapping("/insert")
      public  HSData create(@RequestBody HSData hsdata) {
        return hsRepository.save(hsdata);
      }

      @PutMapping("/update/{id}")
      public HSData update(@PathVariable Long id, @RequestBody HSData hsdata ) {
        hsdata.setId(id);
        return hsRepository.save(hsdata);
      }

      @DeleteMapping("/delete/{id}")
      public void delete(@PathVariable Long id) {
        hsRepository.deleteById(id);
      }
}
