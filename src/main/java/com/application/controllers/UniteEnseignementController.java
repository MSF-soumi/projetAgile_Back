package com.application.controllers;

import com.application.dto.EnseignantDTO;
import com.application.dto.UniteEnseignementDTO;
import com.application.exceptions.EntityNotFoundException;
import com.application.models.*;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;
import com.application.services.UniteEnseignementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/unitesenseignement")
public class UniteEnseignementController {

    private final ModelMapper modelMapper;

    @Autowired
    public final UniteEnseignementService uniteEnseignementService;


    public UniteEnseignementController(ModelMapper modelMapper, UniteEnseignementService uniteEnseignementService) {
        this.modelMapper = modelMapper;
        this.uniteEnseignementService = uniteEnseignementService;
    }

    @ApiOperation(value="Lister toutes les unités d'enseignement")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping
    public List<UniteEnseignementDTO> getAll() {
        var unitesEnseignement = uniteEnseignementService.getAll();
        return unitesEnseignement.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @ApiOperation(value="Lister toutes les unités d'enseignement d'un enseignant")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping(path = "/enseignant/{noEnseignant}")
    public List<UniteEnseignementDTO> getUEByNoEnseignant(@PathVariable Long noEnseignant) {
        var unitesEnseignement = uniteEnseignementService.getUEByEnseignant(noEnseignant);
        return unitesEnseignement.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @ApiOperation(value="Récupérer une unité d'enseignement par ID")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping(path = "/{code_Formation}/{code_ue}")
    public UniteEnseignementDTO getById(@PathVariable String code_Formation,@PathVariable String code_ue){
        UniteEnseignementPK id= new UniteEnseignementPK(code_Formation,code_ue);
        var uniteenseignement = uniteEnseignementService.getById(id);
        return this.convertToDto(uniteenseignement);
    }

    @GetMapping(path="/getEtdPerEnseignantType")
    public ResponseEntity<?> getEtdPerEnseignantType(@RequestParam Long id, @RequestParam int cm, @RequestParam int td, @RequestParam int tp){
        return new ResponseEntity<>(uniteEnseignementService.getEtdPerEnseignantType(id, cm, tp, td), HttpStatus.OK);
    }

//    @GetMapping(path = "/enseignant/etd/{noEnseignant}")
//    public double getSumEtd(Long noEnseignant) {
//    	return uniteEnseignementService.getSumEtd(noEnseignant);
//    }



//    @PutMapping(path="/{code_formation}/{code_ue}")
//    public ResponseEntity<UniteEnseignementDTO> updateUE(@RequestBody UniteEnseignementDTO uniteEnseignement,@RequestParam String code_formation,@RequestParam String code_ue){
//        System.out.println("updateUE");
//        UniteEnseignementPK id=new UniteEnseignementPK(code_formation,code_ue);
//        uniteEnseignement.setId(id);
//        UniteEnseignement UE = convertToEntity(uniteEnseignement);
//        System.out.println("this is ue "+UE);
//        UniteEnseignement ue= uniteEnseignementService.updateUE(id,UE);
//        System.out.println("this is updated ue "+ue);
//        if (ue==null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(convertToDto(ue), HttpStatus.OK);
//    }

    @PutMapping(path = "/modifierEnseignantUE/{code_Formation}/{code_ue}")
    public UniteEnseignementDTO updateEnseignantUE(@PathVariable String code_Formation, @PathVariable String code_ue, @RequestBody EnseignantDTO enseignantDTO){
        UniteEnseignementPK ue_pk = new UniteEnseignementPK(code_Formation, code_ue);
        Enseignant enseignant = convertToEntity(enseignantDTO);
        return convertToDto(uniteEnseignementService.updateEnseignantUE(ue_pk, enseignant));
    }

    @ApiOperation(value="Lister toutes les unités d'enseignement d'une promotion/formation")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping(path = "/promotion/{code_Formation}")
    public List<UniteEnseignementDTO> findByPromo(@PathVariable String code_Formation) {
        return uniteEnseignementService.findByPromo(code_Formation).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private UniteEnseignementDTO convertToDto(UniteEnseignement uniteEnseignement) {
        return modelMapper.map(uniteEnseignement, UniteEnseignementDTO.class);
    }
    private UniteEnseignement convertToEntity(UniteEnseignementDTO uniteEnseignementDTO) {
        return modelMapper.map(uniteEnseignementDTO, UniteEnseignement.class);
    }

    private Enseignant convertToEntity(EnseignantDTO enseignantDTO) {
        return modelMapper.map(enseignantDTO, Enseignant.class);
    }
}
