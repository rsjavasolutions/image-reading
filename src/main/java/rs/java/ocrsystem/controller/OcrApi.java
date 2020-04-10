package rs.java.ocrsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.java.ocrsystem.model.Graphic;
import rs.java.ocrsystem.repository.GraphicRepository;
import rs.java.ocrsystem.service.OcrService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class OcrApi {

    private OcrService ocrService;
    private GraphicRepository graphicRepository;

    @Autowired
    public OcrApi(OcrService ocrService, GraphicRepository graphicRepository) {
        this.ocrService = ocrService;
        this.graphicRepository = graphicRepository;
    }

    @PostMapping("ocr")
    public String doOcr(@RequestBody Graphic graphic) throws IOException {
        String ocr = ocrService.getText(graphic.getUrl());

        Graphic graphicToSave = new Graphic();
        graphicToSave.setUrl(graphic.getUrl());
        graphicToSave.setContent(ocr);
        graphicRepository.save(graphicToSave);
        return ocr;
    }

    @GetMapping("ocr")
    public Iterable<Graphic> getGraphics(){
       return graphicRepository.findAll();
    }

}
