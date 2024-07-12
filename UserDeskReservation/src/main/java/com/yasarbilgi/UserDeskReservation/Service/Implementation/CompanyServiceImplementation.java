package com.yasarbilgi.UserDeskReservation.Service.Implementation;

import com.yasarbilgi.UserDeskReservation.Exception.ResourceNotFoundException;
import com.yasarbilgi.UserDeskReservation.Mapper.CompanyMapper;
import com.yasarbilgi.UserDeskReservation.Repository.CompanyRepository;
import com.yasarbilgi.UserDeskReservation.DTO.CompanyDTO;
import com.yasarbilgi.UserDeskReservation.Entity.Company;
import com.yasarbilgi.UserDeskReservation.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImplementation implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(CompanyMapper::mapToCompanyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));
        return CompanyMapper.mapToCompanyDTO(company);
    }

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = CompanyMapper.mapToCompany(companyDTO);
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.mapToCompanyDTO(savedCompany);
    }

    @Override
    public CompanyDTO updateCompany(Long companyId, CompanyDTO updatedCompanyDTO) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));
        company.setCompanyName(updatedCompanyDTO.getCompanyName());
        Company updatedCompany = companyRepository.save(company);
        return CompanyMapper.mapToCompanyDTO(updatedCompany);
    }

    @Override
    public void deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));
        companyRepository.delete(company);
    }
}