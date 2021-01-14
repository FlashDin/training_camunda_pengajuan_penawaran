package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Dokumen;
import co.id.javan.pengajuanproduk.repositories.DokumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/dokumen")
public class DokumenController {

    @Autowired
    private DokumenRepository dokumenRepository;

    @GetMapping(path = "/db/all")
    public List<Dokumen> findAll() {
        return dokumenRepository.findAll();
    }

    @GetMapping(path = "/bd/{id}")
    public Dokumen findById(@PathVariable long id) {
        return dokumenRepository.findById(id).get();
    }

}
