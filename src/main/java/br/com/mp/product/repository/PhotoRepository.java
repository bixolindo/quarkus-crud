package br.com.mp.product.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.mp.product.model.Photo;
import br.com.mp.product.model.PhotoDTO;
import br.com.mp.product.repository.converter.PhotoConverter;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PhotoRepository implements PanacheRepository<Photo> {

    @Inject
    private PhotoConverter photoConverter;

    public List<PhotoDTO> list() {
        return photoConverter.ormListToDtoList(listAll());
    }

    @Transactional
    public PhotoDTO save(PhotoDTO dto) {
        Photo newPhoto = photoConverter.dtoToOrm(dto);
        persist(newPhoto);
        dto.id = newPhoto.id;
        return dto;
    }

    @Transactional
    public Photo update(Long id, PhotoDTO photo) {
        Photo photoEntity = findById(id);
        Photo updatedPhoto = photoConverter.dtoToOrm(photo);
        photoEntity.photo = updatedPhoto.photo;
        persist(photoEntity);
        return photoEntity;
    }

    @Transactional
    public void remove(Long id) {
        Photo photoEntity = findById(id);
        delete(photoEntity);
    }
}
