package cn.com.guilongkeji.zsst.utils;

import cn.com.guilongkeji.zsst.dto.FileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/10
 */
public  class FileSystem {
    public static List<String> getAllFileName(String filename){
        File file = new File(filename);
        File[] files = file.listFiles();
        List<String> stringList = new ArrayList<>();
        for (File file1:files){
            if (file1.isDirectory()){
                notFile(file1,stringList);
            }else {
                stringList.add(file1.getPath().replace("E:\\zsst\\upload\\img\\",""));
            }
        }
        return stringList;
    }

    private static List<String> notFile(File file,List<String> stringList){
        for (File file1:file.listFiles()){
            if (file1.isDirectory()){
                return notFile(file1,stringList);
            }else {
                stringList.add(file1.getPath().replace("E:\\zsst\\upload\\img\\",""));
            }
        }
        return null;
    }
    public static List<String> FileAllFile(String filename){
        List<String> fileAllName = new ArrayList<>();
        for (File file :new File(filename).listFiles()){
            fileAllName.add(file.getName());
        }
        return fileAllName;
    }

    public static List<String> getFileImg(String filename){
        List<String> fileAllName = new ArrayList<>();
        for (File file:new File(filename).listFiles()){
            try {
                ImageIO.read(file);
                fileAllName.add(file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileAllName;
    }
    public static List<String> getText(String filename) throws IOException {
        List<String> fileAllName = new ArrayList<>();
        for (File file:new File(filename).listFiles()){
            if (file.getName().endsWith("txt")){
                fileAllName.add(new BufferedReader(new InputStreamReader(new FileInputStream(file))).readLine());
            }
        }
        return fileAllName;
    }
    public static FileDto getFile(String fileName){
        File file = new File(fileName);
        FileDto fileDto = new FileDto();
        if (file.isDirectory()&&file.exists()){
            fileDto.setType(true);
            fileDto = isFile(file,fileDto);
        }else {
            new  IOException("该文件非目录或未创建");
        }
        return fileDto;
    }
    private static FileDto isFile(File file,FileDto fileDto){
        if (file.listFiles().length!=0&&fileDto.getType()) {
            List<FileDto> fileDtoList = new ArrayList<>();
            for (File file1 : file.listFiles()) {
                FileDto fileDto1 = new FileDto();
                fileDto1.setFileName(file1.getName());
                if (file1.isDirectory()) {
                    fileDto1.setType(true);
                    fileDto1=isFile(file1,fileDto1);
                } else {
                    fileDto1.setType(false);
                }
                fileDtoList.add(fileDto1);
            }
            fileDto.setFileDto(fileDtoList);
            return fileDto;
        }else {
            return null;
        }
    }

}
