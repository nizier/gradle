package d1.web;

import d1.domain.DM_TS_CL_ORGMapper;
import d1.domain.vm.UserInfo_Get_Vm;
import d1.domain.vm.UserInfo_Res_Vm;
import d1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class FileDownloadController {

    private Logger logger = LoggerFactory.getLogger(FileDownloadController.class);


    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
        try {
            // get your file as InputStream
            String fileFullName="data"+File.separator+fileName+".zip";
            // get your file as InputStream
            InputStream is = new FileInputStream(new File(fileFullName));
            // copy it to response's OutputStream
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            logger.info("下载文件失败{}'", fileName, ex);
        }

    }

}
