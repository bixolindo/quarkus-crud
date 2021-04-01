package br.com.mp.product.model;

import java.io.Serializable;

public class PhotoDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Long id;

    public Integer userId;

    public String base64;

    public PhotoDTO() {
        super();
    }

    public PhotoDTO(Long id, Integer userId, String base64) {
        this.id = id;
        this.userId = userId;
        this.base64 = base64;
    }

}
