#!/usr/bin/env python
import pika, sys, os, time

def main():
  connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
  channel = connection.channel()
  
  channel.queue_declare(queue='hello', durable=True)
  
  def callback(ch, method, properties, body):
    print(" [X] Received %r" % body.decode())
    time.sleep(body.count(b'.'))
    print(" [X] Done")
    print(method.delivery_tag)
    ch.basic_ack(delivery_tag = method.delivery_tag)
  
  channel.basic_consume(queue='hello', on_message_callback=callback)
  
  print(' [*] Waiting for messages. To exit press CTRL+C')
  channel.start_consuming()

if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)