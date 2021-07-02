set -ev

CHANNEL_NAME=mychannel

configtxgen -profile OneOrgOrdererGenesis -outputBlock ./config/genesis.block

configtxgen -profile OneOrgChannel -outputCreateChannelTx ./config/channel.tx -channelID $CHANNEL_NAME

# Create the channel
peer channel create -o orderer.example.com:7050 -c mychannel -f config/channel.tx --outputBlock mychannel.block
# Join peer0.org1.example.com to the channel.
peer channel join -b mychannel.block
#Install chaincode
peer chaincode install -n papercontract -v 0 -p contract -l node
#Instantiate chaincode
peer chaincode instantiate -n papercontract -v 0 -l node -c '{"Args":["org.papernet.commercialpaper:instantiate"]}' -C mychannel -P "AND ('Org1MSP.member')"
