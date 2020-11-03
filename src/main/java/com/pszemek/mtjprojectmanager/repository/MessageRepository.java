package com.pszemek.mtjprojectmanager.repository;

import com.pszemek.mtjprojectmanager.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {
}
