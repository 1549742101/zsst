package cn.com.guilongkeji.zsst.dto;


import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/18
 */
public class FileDto {
    private String FileName;
    private List<FileDto> fileDto;
    private boolean type;

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public List<FileDto> getFileDto() {
        return fileDto;
    }

    public void setFileDto(List<FileDto> fileDto) {
        this.fileDto = fileDto;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public FileDto() {
    }

    public FileDto(String fileName, boolean type) {
        FileName = fileName;
        this.type = type;
    }

    public FileDto(String fileName, List<FileDto> fileDto, boolean type) {
        FileName = fileName;
        this.fileDto = fileDto;
        this.type = type;
    }
}
