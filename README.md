# MyInsurancePortal
MyInsurancePortal -Test-for-SpringBoot Cache

Question	Answer
Do I use Spring Cache (@EnableCaching, @Cacheable) in microservices?	✅ Yes. It’s the standard enterprise approach. Use a distributed backend like Redis.
Do I use Hibernate 2nd-level cache in microservices?	❌ Usually no — unless you have a single-node service or a clustered cache that handles invalidation.
In standalone / monolith apps?	✅ You can combine both for max performance. Hibernate speeds up entity loading, and Spring Cache speeds up higher-level operations.
