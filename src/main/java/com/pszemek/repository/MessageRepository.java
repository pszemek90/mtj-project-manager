package com.pszemek.repository;

import com.pszemek.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    public MessageEntity findByUuid(String uuid);
}
