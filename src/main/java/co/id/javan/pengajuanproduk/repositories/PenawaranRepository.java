package co.id.javan.pengajuanproduk.repositories;

import co.id.javan.pengajuanproduk.pojo.Penawaran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenawaranRepository extends JpaRepository<Penawaran, Long> {

    List<Penawaran> findAllByStatusPenawaran(String statusPenawaran);

}
