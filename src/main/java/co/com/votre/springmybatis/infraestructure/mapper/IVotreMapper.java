package co.com.votre.springmybatis.infraestructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.com.votre.springmybatis.dto.MessageDTO;

@Mapper
public interface IVotreMapper {

    MessageDTO getCampaignRank(@Param("company") String company, @Param("media") String media);

}
