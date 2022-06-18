package com.osama.skp.controller;

import com.osama.skp.service.EmailSubscriberService;
import com.osama.skp.utilityClasses.dto.EmailSubscriberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("admin/emailSubscriber")
public class EmailSubscriberController implements BaseController<EmailSubscriberDto,Long>{
    @Autowired
    private EmailSubscriberService emailSubscriberService;
    @Override
    public ResponseEntity<Page<?>> findAll(Integer page, Integer size) {
        return ResponseEntity.ok(emailSubscriberService.findAll(page, size));
    }

    @Override
    public ResponseEntity<EmailSubscriberDto> findById(Long id) {
        return ResponseEntity.ok(emailSubscriberService.findById(id));
    }

    @Override
    public ResponseEntity<EmailSubscriberDto> save(EmailSubscriberDto emailSubscriberDto) {
        return ResponseEntity.ok(emailSubscriberService.save(emailSubscriberDto));    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        emailSubscriberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteAll(Collection<Long> ids) {
        emailSubscriberService.deleteAll(ids);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "emails.xlsx";
        InputStreamResource file = new InputStreamResource(emailSubscriberService.exportAsExcel());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}
