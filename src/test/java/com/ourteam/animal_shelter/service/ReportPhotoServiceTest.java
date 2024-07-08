package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Report;
import com.ourteam.animal_shelter.model.ReportPhoto;
import com.ourteam.animal_shelter.repository.ReportPhotoRepository;
import com.ourteam.animal_shelter.repository.ReportRepository;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportPhotoServiceTest {

    @Mock
    private ReportPhotoRepository reportPhotoRepository;
    @Mock
    private ReportRepository reportRepository;
    @InjectMocks
    private ReportPhotoService reportPhotoService;

    @BeforeEach
    void setUp() {
        reportPhotoRepository = mock(ReportPhotoRepository.class);
        reportRepository = mock(ReportRepository.class);
        reportPhotoService = new ReportPhotoService(reportPhotoRepository, reportRepository);
    }

    @Test
    void getAddressPhotoTest() {
        // given
        when(reportRepository.findById(3L)).thenReturn(Optional.of(new Report()));

        // when
        reportPhotoService.getAddressPhoto();

        // then
        verify(reportRepository, times(1)).findById(eq(3L));
    }

    @Test
    void кeportPhotoWithNullReportIdTest() {
        // given
        MultipartFile file = new MockMultipartFile("file", "test.jpg",
                "image/jpeg", "test data".getBytes());
        Long reportId = null;

        // when
        try {
            reportPhotoService.uploadReportPhoto(reportId, file);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NullPointerException.class);
        }
    }

    @Test
    public void getReportForm_positive() {
        Report report = new Report();

        when(reportRepository.findById(4L)).thenReturn(java.util.Optional.of(report));

        reportPhotoService.getReportForm();

        verify(reportRepository).findById(4L);
    }

    @Test
    void saveReportTest() {
        // given
        byte[] file = "test".getBytes();
        String caption = "test";

        // when
        reportPhotoService.saveReport(file, caption);

        // then
        verify(reportPhotoRepository, times(1)).save(any(ReportPhoto.class));
        verify(reportRepository, times(1)).save(any(Report.class));
    }

    @Test
    void getExtensionWithFileNameTest() {
        // given
        String fileName = "test.jpg";

        // when
        String extension = reportPhotoService.getExtension(fileName);

        // then
        assertThat(extension).isEqualTo("jpg");
    }

}



