#https://hyperledger-fabric.readthedocs.io/en/release-2.2/config_update.html
set -ev

export CH_NAME=mychannel
export OUTPUT=update-channel
export ORDERER_CONTAINER=orderer.example.com
export TLS_ROOT_CA=/opt/gopath/src/github.com/hyperledger/fabric/peer/crypto-config/peerOrganizations/org1.example.com/tlsca/tlsca.org1.example.com-cert.pem

rm -rf update-channel
mkdir update-channel
peer channel fetch config ${OUTPUT}/config_block.pb -o  $ORDERER_CONTAINER -c $CH_NAME --tls --cafile $TLS_ROOT_CA

configtxlator proto_decode --input ${OUTPUT}/config_block.pb --type common.Block --output ${OUTPUT}/config_block.json

jq .data.data[0].payload.data.config  ${OUTPUT}/config_block.json >  ${OUTPUT}/config.json

cp ${OUTPUT}/config.json ${OUTPUT}/modified_config.json
