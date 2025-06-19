package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Banners;
import org.example.nawa5.repository.BannerRepository;
import org.example.nawa5.service.BannerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public List<Banners> gets() {
        return bannerRepository.findAll();
    }

    @Override
    public void update(Long id, String imageUrl, int displayOrder) {
        Banners banner = bannerRepository.findById(id).get();
        banner.update(imageUrl, displayOrder);
    }

    @Override
    public void delete(Long id) {
        Banners banner = bannerRepository.findById(id).get();
        
        banner.delete();
    }
}
