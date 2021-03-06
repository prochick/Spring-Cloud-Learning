package com.jhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jihongye
 * @date: 2021/03/04/22:58
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Cloud implements Serializable {

    private Long id;
    private String cloudname;
    private String cloudsex;
}
