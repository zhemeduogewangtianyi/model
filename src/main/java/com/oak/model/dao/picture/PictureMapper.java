package com.oak.model.dao.picture;

import com.oak.model.entity.picture.PicturePO;
import com.oak.model.entity.picture.PictureParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "pictureMapper")
public interface PictureMapper {

    public List<PicturePO> pageQuery(PictureParam param);

    public Integer queryCount(PictureParam param);

    public void addPicture(PicturePO po);

    public PicturePO pictureDetail(Long id);

}
