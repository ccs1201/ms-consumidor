package br.com.ccs.msconsumidor.external.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;
import java.util.UUID;

@SuppressWarnings("unused")
@Entity
@DynamicInsert
@DynamicUpdate
@Setter
public class Pessoa {
    @Id
    private UUID id;
    private String nome;
    private Boolean deleted;
    private OffsetDateTime creatAt;
    private OffsetDateTime updateAt;
}
