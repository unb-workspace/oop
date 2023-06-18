public class JobController {
    private final static String[] modalities = {"Presencial", "Hibrido", "Remoto"};
    
    public static String[] getModalities() {
        return modalities;
    }

    public Job createJob(String name, String occupationArea, int salary, String modality, int workload, String requirements) {
        Job job = new Job(name, salary, workload, modality, occupationArea);

        for(String requirement : requirements.split(",")) {
            job.addRequirement(requirement.trim());
        }

        return job;
    }

    public Job createJob(String name, String occupationArea, int salary, String modality, int workload) {
        Job job = new Job(name, salary, workload, modality, occupationArea);

        return job;
    }
}
