package com.house.springboot.service;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.house.springboot.bean.TbHouse;
import com.house.springboot.mapper.TbHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 房屋信息Service业务层处理
 * 
 * @date 2023-03-20
 */
@Service
public class TbHouseServiceImpl
{
    @Autowired
    private TbHouseMapper tbHouseMapper;

    @Value("${diskPath}")
    private String path;

    @Value("${urlPath}")
    private String urlPath;

    /**
     * 上传文件
     * @param file
     * @return
     */
    public String sevefile(MultipartHttpServletRequest file) {
        System.out.println(file.toString());
        boolean flag = false;
        String url = "";
        Map<String, MultipartFile> fileMap = file.getFileMap();
        MultipartFile muFile = fileMap.get("file");
        String orFileName = muFile.getOriginalFilename();
        String extName = orFileName.substring(orFileName.lastIndexOf("."));
        if (!extName.matches(".(png|jpg|gif)$")) {
            return "no";
        }
        String dir = path + "/"+ "upload" + "/";
        File _dir = new File(dir);
        if (!_dir.exists()) {
            _dir.mkdirs();
        }
        InputStream inputStream = null;
        try {
            inputStream = muFile.getInputStream();
        } catch (IOException e) {
            System.out.println("图片上传失败");
            return "no";
        }

        String fileName = UUID.randomUUID()+extName;

        flag = uploadFileOnDisk(inputStream,new File(dir+fileName));
        url = urlPath + fileName ;
        if (flag) {
            System.out.println("图片已经保存到"+url);
            return url;
        }else {
            return "no";
        }
    }

    /**
     * 查询房屋信息
     * 
     * @param id 房屋信息主键
     * @return 房屋信息
     */
    public TbHouse selectTbHouseById(Long id)
    {
        return tbHouseMapper.selectTbHouseById(id);
    }

    /**
     * 查询房屋信息列表
     * 
     * @param tbHouse 房屋信息
     * @return 房屋信息
     */
    public List<TbHouse> selectTbHouseList(TbHouse tbHouse)
    {
        return tbHouseMapper.selectTbHouseList(tbHouse);
    }

    /**
     * 新增房屋信息
     * 
     * @param tbHouse 房屋信息
     * @return 结果
     */
    public int insertTbHouse(TbHouse tbHouse)
    {
        return tbHouseMapper.insertTbHouse(tbHouse);
    }

    /**
     * 修改房屋信息
     * 
     * @param tbHouse 房屋信息
     * @return 结果
     */
    public int updateTbHouse(TbHouse tbHouse)
    {
        return tbHouseMapper.updateTbHouse(tbHouse);
    }

    /**
     * 删除房屋信息信息
     * 
     * @param id 房屋信息主键
     * @return 结果
     */
    public int deleteTbHouseById(Long id)
    {
        return tbHouseMapper.deleteTbHouseById(id);
    }


    /**
     * 将文件存储到硬盘上
     * @param inputStream
     * @param outfile
     * @return
     */
    public boolean uploadFileOnDisk(InputStream inputStream, File outfile) {
        try {
            OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(outfile));

            int BUFFER_SIZE = 1024;
            byte[] buffer=new byte[BUFFER_SIZE];
            while (inputStream.read(buffer) != -1){
                outputStream.write(buffer);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println("图片上传失败");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
