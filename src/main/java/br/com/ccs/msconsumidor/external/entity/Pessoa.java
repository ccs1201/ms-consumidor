package br.com.ccs.msconsumidor.external.entity;

import br.com.messagedispatcher.annotation.EntityEventPublishes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    private UUID id;
    private String nome;
    private Boolean deleted = Boolean.FALSE;
    @CreationTimestamp
    private OffsetDateTime creatAt;
    @UpdateTimestamp
    private OffsetDateTime updateAt;
}
