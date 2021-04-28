package com.instademo.website.Repo;

import com.instademo.website.domain.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageModelRepository extends JpaRepository<ImageModel, Long> {
}
