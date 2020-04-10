package rs.java.ocrsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.java.ocrsystem.model.Graphic;
import rs.java.ocrsystem.service.OcrService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class OcrApi {

    private OcrService ocrService;

    @Autowired
    public OcrApi(OcrService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("ocr")
    public String doOcr(@RequestBody Graphic graphic) throws IOException {
        String ocr = ocrService.getText(graphic.getUrl());
        return ocr;
    }

    @GetMapping("ocr")
    public List<Graphic> getGraphics(){
        //todo
    }

}
