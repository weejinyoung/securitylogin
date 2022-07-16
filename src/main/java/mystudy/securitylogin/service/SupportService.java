package mystudy.securitylogin.service;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.repository.SupportRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository supportRepository;

}
