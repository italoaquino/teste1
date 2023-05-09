package pgfn.gov.transfer.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pgfn.gov.transfer.dto.UploadFileResponse;
import pgfn.gov.transfer.services.ArquivoService;

@RestController
@RequestMapping(value = "/api/file")
public class ArquivoController {
    private final ArquivoService arquivoService;

    public ArquivoController(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<UploadFileResponse> uploadFile(@RequestParam("image") MultipartFile file,
                                        @RequestParam("nomeCompleto") String nomeCompleto,
                                        @RequestParam("email") String email,
                                        @RequestParam("cpf") String cpf,
                                        @RequestParam("telefone") String telefone,
                                        @RequestParam("cargo") String cargo
                                        ) {
        UploadFileResponse uploadImage = arquivoService.uploadImagemToFileSystem(file, nomeCompleto, email, cpf, telefone, cargo);
        return new ResponseEntity<>(uploadImage, HttpStatus.ACCEPTED);
    }

}


