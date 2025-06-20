package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Banner;
import org.example.nawa5.domain.BannerStatus;
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
    public List<Banner> gets() {
        return bannerRepository.findBanners(BannerStatus.REGISTERED, true);
    }

    @Override
    public void update(Long id, String imageUrl, String linkUrl, int displayOrder) {
        Banner banner = bannerRepository.findById(id).get();

        banner.update(imageUrl, linkUrl, displayOrder);
    }

    @Override
    public void delete(Long id) {
        Banner banner = bannerRepository.findById(id).get();

        banner.delete();
    }
}
