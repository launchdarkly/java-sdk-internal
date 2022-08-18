package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.AttributeRef;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Internal representation of the configuration properties for {@link DefaultEventProcessor}.
 * This class is not exposed in the public SDK API.
 */
public final class EventsConfiguration {
  /**
   * Default number of event-sending worker threads.
   */
  public static final int DEFAULT_EVENT_SENDING_THREAD_POOL_SIZE = 5;
  
  final boolean allAttributesPrivate;
  final int capacity;
  final ConnectionStatusMonitor connectionStatusMonitor;
  final EventContextDeduplicator contextDeduplicator;
  final long diagnosticRecordingIntervalMillis;
  final DiagnosticStore diagnosticStore;
  final EventSender eventSender;
  final int eventSendingThreadPoolSize;
  final URI eventsUri;
  final long flushIntervalMillis;
  final boolean initiallyInBackground;
  final List<AttributeRef> privateAttributes;
  
  /**
   * Creates an instance.
   * 
   * @param allAttributesPrivate true if all attributes are private
   * @param capacity event buffer capacity (if zero or negative, a value of 1 is used to prevent errors)
   * @param connectionStatusMonitor optional ConnectionStatusMonitor; null for server-side SDK
   * @param contextDeduplicator optional EventContextDeduplicator; null for client-side SDK
   * @param diagnosticRecordingIntervalMillis diagnostic recording interval
   * @param diagnosticStore optional DiagnosticStore; null if diagnostics are disabled
   * @param eventSender event delivery component; must not be null
   * @param eventSendingThreadPoolSize number of worker threads for event delivery; zero to use the default
   * @param eventsUri events base URI
   * @param flushIntervalMillis event flush interval
   * @param initiallyInBackground true if we should start out in background mode (see
   *   {@link DefaultEventProcessor#setInBackground(boolean)})
   * @param privateAttributes list of private attribute references; may be null
   */
  public EventsConfiguration(
      boolean allAttributesPrivate,
      int capacity,
      ConnectionStatusMonitor connectionStatusMonitor,
      EventContextDeduplicator contextDeduplicator,
      long diagnosticRecordingIntervalMillis,
      DiagnosticStore diagnosticStore,
      EventSender eventSender,
      int eventSendingThreadPoolSize,
      URI eventsUri,
      long flushIntervalMillis,
      boolean initiallyInBackground,
      Collection<AttributeRef> privateAttributes
      ) {
    super();
    this.allAttributesPrivate = allAttributesPrivate;
    this.capacity = capacity >= 0 ? capacity : 1;
    this.connectionStatusMonitor = connectionStatusMonitor;
    this.contextDeduplicator = contextDeduplicator;
    this.diagnosticRecordingIntervalMillis = diagnosticRecordingIntervalMillis;
    this.diagnosticStore = diagnosticStore;
    this.eventSender = eventSender;
    this.eventSendingThreadPoolSize = eventSendingThreadPoolSize >= 0 ? eventSendingThreadPoolSize :
      DEFAULT_EVENT_SENDING_THREAD_POOL_SIZE;
    this.eventsUri = eventsUri;
    this.flushIntervalMillis = flushIntervalMillis;
    this.initiallyInBackground = initiallyInBackground;
    this.privateAttributes = privateAttributes == null ? Collections.emptyList() : new ArrayList<>(privateAttributes);
  }
}