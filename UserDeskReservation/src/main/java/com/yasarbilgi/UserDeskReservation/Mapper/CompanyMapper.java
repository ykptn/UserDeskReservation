package com.yasarbilgi.UserDeskReservation.Mapper;

import com.yasarbilgi.UserDeskReservation.DTO.CompanyDTO;
import com.yasarbilgi.UserDeskReservation.Entity.Company;

public class CompanyMapper {

    public static CompanyDTO mapToCompanyDTO(Company company) {
        return new CompanyDTO(
                company.getId(),
                company.getCompanyName()
        );
    }

    public static Company mapToCompany(CompanyDTO companyDTO) {
        return new Company(
                companyDTO.getId(),
                companyDTO.getCompanyName()
        );
    }
}
