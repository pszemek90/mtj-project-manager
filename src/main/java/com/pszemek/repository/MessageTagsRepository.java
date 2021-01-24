package com.pszemek.repository;

import com.pszemek.entity.MessageTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageTagsRepository extends JpaRepository<MessageTagsEntity, UUID> {
    MessageTagsEntity findByTag(String tag);

}
