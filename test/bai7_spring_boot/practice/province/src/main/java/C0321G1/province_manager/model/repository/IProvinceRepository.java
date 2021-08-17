package C0321G1.province_manager.model.repository;

import C0321G1.province_manager.model.bean.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}
