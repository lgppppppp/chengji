package edu.ait.listnames.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XiaoGuiYou
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto{
    public String userId;
    /**
     * 1 学生 2 老师 3管理员
     */
    public Integer type;
}
