package co.com.votre.springmybatis.bussines;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import co.com.votre.springmybatis.dto.MessageDTO;
import co.com.votre.springmybatis.infraestructure.mapper.IVotreMapper;

@Service("mybatisService")
@AllArgsConstructor
public class MybatisBussines {

    IVotreMapper votreMapper;

    
    public String dummy() {
        return "hola Mundo !!!";
    }
    
    public MessageDTO getCampaignRank(String company, String media) {
        return votreMapper.getCampaignRank(company, media);
    }

}
