from datetime import datetime
from datetime import timedelta

# The DAG object; we'll need this to instantiate a DAG
from airflow import DAG
from airflow.operators.bash_operator import BashOperator
# Operators; we need this to operate!
from airflow.operators.dummy_operator import DummyOperator
from airflow.sensors.time_delta_sensor import TimeDeltaSensor

# These args will get passed on to each operator
# You can override them on a per-task basis during operator initialization
default_args = {
    'owner': 'airflow',
    'depends_on_past': False,
    'email': ['airflow@example.com'],
    'email_on_failure': False,
    'email_on_retry': False,
    'retries': 1,
    'retry_delay': timedelta(minutes=5),
    # 'queue': 'bash_queue',
    # 'pool': 'backfill',
    # 'priority_weight': 10,
    # 'end_date': datetime(2016, 1, 1),
    # 'wait_for_downstream': False,
    # 'dag': dag,
    # 'sla': timedelta(hours=2),
    # 'execution_timeout': timedelta(seconds=300),
    # 'on_failure_callback': some_function,
    # 'on_success_callback': some_other_function,
    # 'on_retry_callback': another_function,
    # 'sla_miss_callback': yet_another_function,
    # 'trigger_rule': 'all_success'
}
dag = DAG(
    'dag2',
    default_args=default_args,
    start_date=datetime(2020, 8, 1, 19, 14),
    #schedule_interval=timedelta(minutes=1),
    schedule_interval='* * * * *',
)

dummyOperator = DummyOperator(
    task_id='DummyOperator',
    dag=dag,
)

dummyOperator2 = DummyOperator(
    task_id='DummyOperator2',
    dag=dag,
)

#timeSensor = TimeSensor(
  #  task_id='TimeSensor',
  #  dag=dag,
  #  poke_interval=5,
  #  target_time=time(20, 33, 0)
#)

bashOperator = BashOperator(
    task_id='BashOperator',
    bash_command='sleep 30',
    dag=dag,
)

timeDeltaSensor = TimeDeltaSensor(
    task_id='TimeDeltaSensor',
    dag=dag,
    poke_interval=5,
    delta=timedelta(seconds=20)
)

dummyOperator >> timeDeltaSensor >> dummyOperator2