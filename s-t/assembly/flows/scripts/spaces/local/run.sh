#!/usr/bin/env bash

SCRIPT_DIR=$(dirname "$0")

if [ -z ${M_ENV_CONF_SOURCE} ];
then
 source "_"
else
 M_ENV_CONF_SOURCE_INNER=${M_ENV_CONF_SOURCE}
 source ${M_ENV_CONF_SOURCE_INNER}
fi

M_CLASS="m.d.s.t.cluster.transformation.Runner"

M_EXECUTOR_MEMORY=8GB
M_NUM_EXECUTORS=8
M_MASTER="yarn"
M_DEPLOY_MODE="client"
M_DRIVER_MEMORY=4g
M_CORES=2

spark-submit \
--class ${M_CLASS} \
--master ${M_MASTER} \
--deploy-mode ${M_DEPLOY_MODE} \
--num-executors ${M_NUM_EXECUTORS} \
--executor-memory ${M_EXECUTOR_MEMORY} \
--driver-memory ${M_DRIVER_MEMORY} \
--total-executor-cores ${M_CORES} \
${SCRIPT_DIR}/cluster/transformation/transformation.jar
