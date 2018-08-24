//package com.oak.model.controller.file;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.*;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class FileUploadController {
//
//    @RequestMapping("/file")
//    public String file(){
//        System.out.println("Controller");
//        return "/file/file";
//    }
//
//    @RequestMapping("/batchFile")
//    public String batchFile(){
//        System.out.println("Controller");
//        return "/file/multifile";
//    }
//
//    @RequestMapping("/upload")
//    @ResponseBody
//    public String handleFileUpload(@RequestParam("file") MultipartFile file){
//        if(!file.isEmpty()){
//            /*
//             * 这段代码执行完毕之后，图片上传到了工程的跟路径；
//             * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
//             * 等等;
//             * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
//             * 1、文件路径；
//             * 2、文件名；
//             * 3、文件格式;
//             * 4、文件大小的限制;
//             */
//            try{
////                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
//                File f = new File("f://files");
//                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
//                bos.write(file.getBytes());
//                bos.flush();
//                bos.close();
//            }catch (FileNotFoundException ex){
//                ex.printStackTrace();
//                return "上传失败，" + ex.getMessage();
//            }catch (IOException ex){
//                ex.printStackTrace();
//                return "上传失败，" + ex.getMessage();
//            }catch (Exception ex){
//                ex.printStackTrace();
//                return "上传失败，" + ex.getMessage();
//            }
//            return "上传成功";
//        }
//        return "上传文件不能为空！";
//    }
//
//    /**
//     * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
//     * @param request
//     * @return
//     */
//
//    @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
//    public@ResponseBody
//    String handleFileUpload(HttpServletRequest request){
//        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
//        MultipartFile file = null;
//        BufferedOutputStream stream = null;
//        for (int i =0; i< files.size(); ++i) {
//            file = files.get(i);
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
//                    stream.write(bytes);
//                    stream.close();
//                } catch (Exception e) {
//                    stream =  null;
//                    return"You failed to upload " + i + " => " + e.getMessage();
//                }
//            } else {
//                return"You failed to upload " + i + " because the file was empty.";
//            }
//        }
//        return"upload successful";
//    }
//}
