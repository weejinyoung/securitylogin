package mystudy.securitylogin.service;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
}
