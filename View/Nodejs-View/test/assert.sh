# /bin/sh
# usage export REQUIRED_NODE_VERSION=v14.8.1 && ./test/assert.sh
REQUIRED_NODE_VERSION=${REQUIRED_NODE_VERSION:-unknow}
echo "校验版本 $REQUIRED_NODE_VERSION"
CURRENT_NODE_VERSION=$(node --version)
if [[ "$REQUIRED_NODE_VERSION" == "$CURRENT_NODE_VERSION" ]]; then
  echo "[INFO] 版本校验成功 期望版本 $REQUIRED_NODE_VERSION 当前版本$CURRENT_NODE_VERSION "
  exit 0
else
  echo "[ERROR] 版本校验失败 期望版本 $REQUIRED_NODE_VERSION 当前版本$CURRENT_NODE_VERSION "
  exit 1
fi