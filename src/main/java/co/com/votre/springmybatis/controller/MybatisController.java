package co.com.votre.springmybatis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import co.com.votre.springmybatis.bussines.MybatisBussines;
import co.com.votre.springmybatis.dto.MessageDTO;

@RestController
@RequestMapping("/mybatis")
@AllArgsConstructor
public class MybatisController {

    private final MybatisBussines business;

    @GetMapping("/")
    public String dummy() {
        return business.dummy();
    }

    @GetMapping("/{company}/{media}")
    public ResponseEntity<MessageDTO> getCampaignRank(@PathVariable String company, @PathVariable String media) {
        return new ResponseEntity<>(business.getCampaignRank(company, media), HttpStatus.ACCEPTED);
    }
}
