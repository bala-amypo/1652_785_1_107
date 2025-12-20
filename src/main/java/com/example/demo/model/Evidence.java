@ManyToOne(optional = false)
    @JoinColumn(name = "claim_id")
    private DamageClaim claim;

    private String evidenceType; // IMAGE | DOCUMENT | TEXT

    private String fileUrl;

    private LocalDateTime uploadedAt;
