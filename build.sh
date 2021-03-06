mvn clean install -f payment-service-api
[ $? -eq 0 ] || exit 1

mvn clean install -f policy-service-api
[ $? -eq 0 ] || exit 1

mvn clean install -f pricing-service-api
[ $? -eq 0 ] || exit 1

mvn clean install -f product-service-api
[ $? -eq 0 ] || exit 1

mvn clean install -f auth-service
[ $? -eq 0 ] || exit 1

mvn clean install -f payment-service
[ $? -eq 0 ] || exit 1

mvn clean install -f policy-service -Dmaven.test.skip
[ $? -eq 0 ] || exit 1

mvn clean install -f pricing-service -Dmaven.test.skip
[ $? -eq 0 ] || exit 1

mvn clean install -f product-service
[ $? -eq 0 ] || exit 1

mvn clean install -f agent-portal-gateway
[ $? -eq 0 ] || exit 1

(
  cd web-vue
  yarn install
  yarn run build
)
[ $? -eq 0 ] || exit 1

