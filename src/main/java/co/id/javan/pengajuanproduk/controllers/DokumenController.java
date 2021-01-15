package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Dokumen;
import co.id.javan.pengajuanproduk.repositories.DokumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task/dokumen")
public class DokumenController {

    @Autowired
    private DokumenRepository dokumenRepository;

    @GetMapping(path = "/db/all")
    public List<Dokumen> findAll() {
        return dokumenRepository.findAll();
    }

    @GetMapping(path = "/db/{id}")
    public Dokumen findById(@PathVariable long id) {
        return dokumenRepository.findById(id).get();
    }

//    @PostMapping(path = "/db")
//    public Map<String, Object> save(@RequestBody Dokumen dokumen) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "Data berhasil disimpan");
//        try {
//            dokumenRepository.save(dokumen);
//        } catch (Exception e) {
//            map.put("msg", "Data gagal disimpan");
//        }
//        return map;
//    }
//
//    @PostMapping("/db/upload")
//    public Map<String, Object> singleFileUpload(@RequestParam("data") String data,
//                                                @RequestParam("file") MultipartFile file) {
//        Map<String, Object> map = new HashMap<>();
//        if (file.isEmpty()) {
//            map.put("msg1", "File kosong silahkan pilih");
//        }
//        try {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(System.getProperty("user.dir") + "/dok/" + file.getOriginalFilename());
//            Files.write(path, bytes);
//            map.put("msg1", "Upload file berhasil");
//            Dokumen dokumen = new Dokumen();
//            this.save(dokumen);
//        } catch (Exception e) {
//            map.put("msg1", "File gagal diupload");
//        }
//        return map;
//    }

}
