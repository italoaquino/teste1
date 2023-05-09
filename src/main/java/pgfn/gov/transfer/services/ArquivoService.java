package pgfn.gov.transfer.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pgfn.gov.transfer.dto.UploadFileResponse;
import pgfn.gov.transfer.entities.ArquivoEntity;
import pgfn.gov.transfer.repositories.ArquivoRepository;
import pgfn.gov.transfer.services.exceptions.DataIntegrityException;
import pgfn.gov.transfer.util.ValidateValues;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ArquivoService {

    private final ArquivoRepository arquivoRepo;

    public ArquivoService(ArquivoRepository arquivoRepo) {
        this.arquivoRepo = arquivoRepo;
    }

    @Value("${FOLDER_PATH}")
    private String FOLDER_PATH;

    public UploadFileResponse uploadImagemToFileSystem(MultipartFile file,  String nomeCompleto, String email, String cpf, String telefone, String cargo){

        UploadFileResponse uploadFileResponse = new UploadFileResponse();

        validateParamns(nomeCompleto, email, cpf, telefone, cargo);

        UUID id = UUID.randomUUID();
        String nameFile = id.toString()+"_"+file.getOriginalFilename();
        String pathFile=FOLDER_PATH+nameFile;

       ArquivoEntity arquivoEntity = saveFile(id, nameFile, file.getContentType(),  pathFile, nomeCompleto, email, cpf, telefone, cargo);

        if(arquivoEntity == null){
            uploadFileResponse.setMessage("Erro to save arquivo.");
            return uploadFileResponse;
        }

        try {
            file.transferTo(new File(pathFile));
            uploadFileResponse.setMessage("Upload with sucess.");
        } catch (IOException e) {
            throw new pgfn.gov.transfer.services.exceptions.IOException(e.getMessage());
        }

        return uploadFileResponse;

    }

    private void validateParamns(String nomeCompleto, String email, String cpf, String telefone, String cargo){

        if(nomeCompleto == null || nomeCompleto == ""){
            throw new IllegalArgumentException( "Nome inválido.");
        }

        if(!ValidateValues.validarEmail(email)){
            throw new IllegalArgumentException("Email inválido.");
        }

        if(cargo == null || cargo == ""){
            throw new IllegalArgumentException("Cargo inválido.");
        }

        if(!ValidateValues.ValidarCPF(cpf)){
            throw new IllegalArgumentException("Cpf inválido.");
        }

        if(telefone == null || telefone == "" || telefone.length() != 11
        ){
            throw new IllegalArgumentException("Telefone inválido.");
        }
    }

    private ArquivoEntity saveFile(UUID id, String nameFile, String typeFile, String pathFile , String nomeCompleto, String email, String cpf, String telefone, String cargo){
        try{
            ArquivoEntity arquivoEntity = arquivoRepo.save(
                    new ArquivoEntity(id, nameFile , typeFile, pathFile, nomeCompleto, email, cpf, telefone, cargo)
            );
            return arquivoEntity;
        }catch (DataIntegrityException dt){
            throw new DataIntegrityException(dt.getMessage());
        }

    }


}

