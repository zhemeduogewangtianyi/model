package com.oak.model.service.picture;

import com.oak.model.entity.picture.PictureAddParam;
import com.oak.model.entity.picture.PictureParam;
import com.oak.model.entity.picture.PictureVO;
import com.oak.model.entity.responseResult.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {
    public List<PictureVO> pageQuery(PictureParam param);

    public Integer queryCount(PictureParam param);

    public ResponseResult addPicture(MultipartFile file, PictureAddParam param);

    public PictureVO pictureDetail(Long id);

}
