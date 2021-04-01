package br.com.mp.product.repository.converter;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.mp.product.model.Person;
import br.com.mp.product.model.Photo;
import br.com.mp.product.model.PhotoDTO;

@ApplicationScoped
public class PhotoConverter {

    public PhotoDTO ormToDto(Photo photo) {
        byte[] decoded = Base64.getDecoder().decode(photo.photo);
        return new PhotoDTO(photo.id, photo.user.id.intValue(), new String(decoded));
    }

    public Photo dtoToOrm(PhotoDTO photoDTO) {
        byte[] name = Base64.getEncoder().encode(photoDTO.base64.getBytes());
        Photo newPhoto = new Photo();
        newPhoto.photo = name;
        Person person = new Person();
        person.id = photoDTO.userId.longValue();
        newPhoto.user = person;
        return newPhoto;
    }

    public List<PhotoDTO> ormListToDtoList(List<Photo> ormList) {
        List<PhotoDTO> dtos = new ArrayList<PhotoDTO>();
        if (ormList != null) {
            ormList.stream().forEach(orm -> dtos.add(ormToDto(orm)));
            return dtos;
        }
        return dtos;
    }

}
