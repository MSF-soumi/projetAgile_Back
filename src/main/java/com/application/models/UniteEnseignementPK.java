package com.application.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Embeddable
public class UniteEnseignementPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code_Formation;
    private String code_ue;
}
